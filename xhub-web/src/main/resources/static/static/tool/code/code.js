layui.use(['jquery'], function () {
    var $ = layui.$;

    /******** 加密/解密 ********/
    // 加密
    $("#encrypt").click(function () {
        let input = $("#encryptInput").val();
        let password = $("#encryptPassword").val();
        let output;
        try {
            switch ($("input[name='encryptAlgorithm']:checked").val()) {
                case "AES":
                    output = CryptoJS.AES.encrypt(input, password).toString();
                    break;
                case "DES":
                    output = CryptoJS.DES.encrypt(input, password).toString();
                    break;
                case "RC4":
                    output = CryptoJS.RC4.encrypt(input, password).toString();
                    break;
                case "Rabbit":
                    output = CryptoJS.Rabbit.encrypt(input, password).toString();
                    break;
                case "TripleDes":
                    output = CryptoJS.TripleDES.encrypt(input, password).toString();
                    break;
                default:
                    output = "错误信息：未实现的算法"
                    break;
            }
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        $("#encryptOutput").val(output);
    });

    // 解密
    $("#decrypt").click(function () {
        let input = $("#encryptInput").val();
        let password = $("#encryptPassword").val();
        let output;
        try {
            switch ($("input[name='encryptAlgorithm']:checked").val()) {
                case "AES":
                    output = CryptoJS.AES.decrypt(input, password).toString(CryptoJS.enc.Utf8);
                    break;
                case "DES":
                    output = CryptoJS.DES.decrypt(input, password).toString(CryptoJS.enc.Utf8);
                    break;
                case "RC4":
                    output = CryptoJS.RC4.decrypt(input, password).toString(CryptoJS.enc.Utf8);
                    break;
                case "Rabbit":
                    output = CryptoJS.Rabbit.decrypt(input, password).toString(CryptoJS.enc.Utf8);
                    break;
                case "TripleDes":
                    output = CryptoJS.TripleDES.decrypt(input, password).toString(CryptoJS.enc.Utf8);
                    break;
                default:
                    output = "错误信息：未实现的算法"
                    break;
            }
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        if (output == "") {
            output = "错误信息：解密失败，请检查输入的内容和密码";
        }
        $("#encryptOutput").val(output);
    });

    // 清空
    $("#encryptClear").click(function () {
        $("#encryptInput").val("");
        $("#encryptPassword").val("");
        $("#encryptOutput").val("");
    });

    /******** 哈希/散列 ********/
    // 生成
    function hashMake(isUpper = false) {
        let input = $("#hashInput").val();
        let password = $("#hashPassword").val();
        let output;
        try {
            switch ($("input[name='hashAlgorithm']:checked").val()) {
                case "SHA1":
                    output = CryptoJS.SHA1(input).toString();
                    break;
                case "SHA224":
                    output = CryptoJS.SHA224(input).toString();
                    break;
                case "SHA256":
                    output = CryptoJS.SHA256(input).toString();
                    break;
                case "SHA384":
                    output = CryptoJS.SHA384(input).toString();
                    break;
                case "SHA512":
                    output = CryptoJS.SHA512(input).toString();
                    break;
                case "MD5":
                    output = CryptoJS.MD5(input).toString();
                    break;
                default:
                    output = "错误信息：未实现的算法"
                    break;
            }
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        if (isUpper) {
            output = output.toUpperCase();
        }
        $("#hashOutput").val(output);
    }

    $("#hashMakeLower").click(function () {
        hashMake();
    });

    $("#hashMakeUpper").click(function () {
        hashMake(true);
    });

    $("#hashClear").click(function () {
        $("#hashInput").val("");
        $("#hashOutput").val("");
    });

    /******** Base64 ********/
    // 编码
    $("#baseEncode").click(function () {
        let input = $("#baseInput").val();
        let output;
        try {
            output = btoa(input);
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        $("#baseOutput").val(output);
    });

    // 解码
    $("#baseDecode").click(function () {
        let input = $("#baseInput").val();
        let output;
        try {
            output = atob(input);
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        $("#baseOutput").val(output);
    });

    // 交换
    $("#baseExchange").click(function () {
        let tmp = $("#baseInput").val();
        $("#baseInput").val($("#baseOutput").val());
        $("#baseOutput").val(tmp);
    });

    // 清空
    $("#baseClear").click(function () {
        $("#baseInput").val("");
        $("#baseOutput").val("");
    });

    /******** URLEncode ********/
    // 编码
    $("#urlEncode").click(function () {
        let input = $("#urlInput").val();
        let output;
        try {
            output = encodeURIComponent(input);
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        $("#urlOutput").val(output);
    });

    // 解码
    $("#urlDecode").click(function () {
        let input = $("#urlInput").val();
        let output;
        try {
            output = decodeURIComponent(input);
        } catch (err) {
            output = "错误信息：" + err.message;
        }
        $("#urlOutput").val(output);
    });

    // 交换
    $("#urlExchange").click(function () {
        let tmp = $("#urlInput").val();
        $("#urlInput").val($("#urlOutput").val());
        $("#urlOutput").val(tmp);
    });

    // 清空
    $("#urlClear").click(function () {
        $("#urlInput").val("");
        $("#urlOutput").val("");
    });

    /******** Unicode编码 ********/
    function ascii(str) {
        var value = '';
        for (var i = 0; i < str.length; i++) {
            value += '\&#x' + left_zero_4(parseInt(str.charCodeAt(i)).toString(16)) + ';';
        }
        return value;
    }

    function unicode(str) {
        var value = '';
        for (var i = 0; i < str.length; i++) {
            value += '\\u' + left_zero_4(parseInt(str.charCodeAt(i)).toString(16));
        }
        return value;
    }

    function left_zero_4(str) {
        if (str != null && str != '' && str != 'undefined') {
            if (str.length == 2) {
                return '00' + str;
            }
        }
        return str;
    }

    function unicode1(str) {
        var value = '';
        for (var i = 0; i < str.length; i++)
            value += '&#' + str.charCodeAt(i) + ';';
        return value;
    }

    function reconvert(str) {
        str = str.replace(/(\\u)(\w{1,4})/gi, function ($0) {
            return (String.fromCharCode(parseInt((escape($0).replace(/(%5Cu)(\w{1,4})/g, "$2")), 16)));
        });
        str = str.replace(/(&#x)(\w{1,4});/gi, function ($0) {
            return String.fromCharCode(parseInt(escape($0).replace(/(%26%23x)(\w{1,4})(%3B)/g, "$2"), 16));
        });
        str = str.replace(/(&#)(\d{1,6});/gi, function ($0) {
            return String.fromCharCode(parseInt(escape($0).replace(/(%26%23)(\d{1,6})(%3B)/g, "$2")));
        });

        return str;
    }

    // 执行转换
    function unicodeOpt(opt) {
        let input = $("#uniInput").val();
        let output;
        switch (opt) {
            case "CONVERT_FMT1":
                output = ascii(input);
                break;
            case "CONVERT_FMT2":
                output = unicode(input);
                break;
            case "CONVERT_FMT3":
                output = unicode1(input);
                break;
            case "RECONVERT":
                output = reconvert(input);
                break;
            default :
                output = "";
                break;
        }
        $("#uniOutput").val(output);
    }

    // 中文转Unicode
    $("#uniCONVERT_FMT2").click(function () {
        unicodeOpt("CONVERT_FMT2");
    });

    // Unicode转中文
    // ASCII转Unicode
    $("#uniRECONVERT").click(function () {
        unicodeOpt("RECONVERT");
    });

    // Unicode转ASCII
    $("#uniCONVERT_FMT3").click(function () {
        unicodeOpt("CONVERT_FMT3");
    });

    // 中文转&amp;#XXXX
    $("#uniCONVERT_FMT1").click(function () {
        unicodeOpt("CONVERT_FMT1");
    });

    // 交换
    $("#uniExchange").click(function () {
        let tmp = $("#urlInput").val();
        $("#uniInput").val($("#uniOutput").val());
        $("#uniOutput").val(tmp);
    });

    // 清空
    $("#uniClear").click(function () {
        $("#uniInput").val("");
        $("#uniOutput").val("");
    });

});
