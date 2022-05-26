layui.use(['jquery', 'layer'], function () {
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
            output = Base64.encode(input);
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
            output = Base64.decode(input);
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
});