// 屏蔽Ctrl+S
window.addEventListener("keydown", function (e) {
    //可以判断是不是mac，如果是mac,ctrl变为花键
    //event.preventDefault() 方法阻止元素发生默认的行为。
    if (e.code == 83 && (navigator.platform.match("Mac") ? e.metaKey : e.ctrlKey)) {
        e.preventDefault();
    }
}, false);

//计算头函数 用来缩进
function _setXmlPrefix(prefixIndex) {
    var result = '';
    var span = '    ';//缩进长度
    var output = [];
    for (var i = 0; i < prefixIndex; ++i) {
        output.push(span);
    }
    result = output.join('');
    return result;
}

//格式化xml代码
function formatXml(xmlStr) {
    text = xmlStr;
    //使用replace去空格
    text = '\n' + text.replace(/(<\w+)(\s.*?>)/g, function ($0, name, props) {
        return name + ' ' + props.replace(/\s+(\w+=)/g, " $1");
    }).replace(/>\s*?</g, ">\n<");
    //处理注释
    text = text.replace(/\n/g, '\r').replace(/<!--(.+?)-->/g, function ($0, text) {
        var ret = '<!--' + escape(text) + '-->';
        return ret;
    }).replace(/\r/g, '\n');
    //调整格式  以压栈方式递归调整缩进
    var rgx = /\n(<(([^\?]).+?)(?:\s|\s*?>|\s*?(\/)>)(?:.*?(?:(?:(\/)>)|(?:<(\/)\2>)))?)/mg;
    var nodeStack = [];
    var output = text.replace(rgx, function ($0, all, name, isBegin, isCloseFull1, isCloseFull2, isFull1, isFull2) {
        var isClosed = (isCloseFull1 == '/') || (isCloseFull2 == '/') || (isFull1 == '/') || (isFull2 == '/');
        var prefix = '';
        if (isBegin == '!') {//!开头
            prefix = _setXmlPrefix(nodeStack.length);
        } else {
            if (isBegin != '/') {///开头
                prefix = _setXmlPrefix(nodeStack.length);
                if (!isClosed) {//非关闭标签
                    nodeStack.push(name);
                }
            } else {
                nodeStack.pop();//弹栈
                prefix = _setXmlPrefix(nodeStack.length);
            }
        }
        var ret = '\n' + prefix + all;
        return ret;
    });
    var prefixSpace = -1;
    var outputText = output.substring(1);
    //还原注释内容
    outputText = outputText.replace(/\n/g, '\r').replace(/(\s*)<!--(.+?)-->/g, function ($0, prefix, text) {
        if (prefix.charAt(0) == '\r')
            prefix = prefix.substring(1);
        text = unescape(text).replace(/\r/g, '\n');
        var ret = '\n' + prefix + '<!--' + text.replace(/^\s*/mg, prefix) + '-->';
        return ret;
    });
    outputText = outputText.replace(/\s+$/g, '').replace(/\r/g, '\r\n');
    return outputText;
}

//压缩XML代码
function compressXml(xml) {
    return xml.replace(/\<![ \r\n\t]*(--([^\-]|[\r\n]|-[^\-])*--[ \r\n\t]*)\>/g, "")
        .replace(/[ \r\n\t]{1,}xmlns/g, ' xmlns').replace(/>\s{0,}</g, "><");
}

// 转换原始数据
function convertOriginalData(xslt, source) {
    try {
        let processor = new XSLTProcessor();
        processor.importStylesheet(new DOMParser().parseFromString(xslt, "text/xml"));
        let result = processor.transformToDocument(new DOMParser().parseFromString(source, "text/xml"));
        return result.body.getElementsByTagName("pre")[0].innerHTML;
    } catch (err) {
        return "错误信息：" + err.message;
    }
}