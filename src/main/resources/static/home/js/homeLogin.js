

//window.setTimeout(showfh,3000);
var timer;
function showfh() {
    fhi = 1;
    //关闭提示晃动屏幕，注释掉这句话即可
    timer = setInterval(xzfh2, 10);
};
var current = 0;

function xzfh() {
    current = (current) % 360;
    document.body.style.transform = 'rotate(' + current + 'deg)';
    current++;
    if (current > 360) {
        current = 0;
    }
};
var fhi = 1;
var current2 = 1;

function xzfh2() {
    if (fhi > 50) {
        document.body.style.transform = 'rotate(0deg)';
        clearInterval(timer);
        return;
    }
    current = (current2) % 360;
    document.body.style.transform = 'rotate(' + current + 'deg)';
    current++;
    if (current2 == 1) {
        current2 = -1;
    } else {
        current2 = 1;
    }
    fhi++;
};


//登录
function severCheck() {
    if (check()) {
        var data = $("#loginForm").serialize();
        $.ajax({
            type: "POST",
            url: 'login',
            data: data,
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.code==0) {
                    saveCookie();
                    window.location.href = "index";
                }else if (data.code == 501) {
                    $("#loginphone").tips({
                        side: 1,
                        msg: "该用户不存在",
                        bg: '#FF5080',
                        time: 3
                    });
                    showfh();
                    $("#loginname").focus();
                } else if (data.code == 502) {
                    $("#loginphone").tips({
                        side: 1,
                        msg: "登录手机号或密码有误",
                        bg: '#FF5080',
                        time: 3
                    });
                    showfh();
                    $("#loginname").focus();
                } else if (data.code == 503) {
                    $("#code").tips({
                        side: 1,
                        msg: "验证码输入有误",
                        bg: '#FF5080',
                        time: 3
                    });
                    showfh();
                    $("#code").focus();
                } else if (data.code == 504) {
                    $("#loginbox").tips({
                        side : 1,
                        msg : '该账号不可用 ...',
                        bg : '#FF5080',
                        time : 5
                    });
                    showfh();
                    $("#code").focus();
                } else {
                    $("#loginname").tips({
                        side: 1,
                        msg: "缺少参数",
                        bg: '#FF5080',
                        time: 3
                    });
                    showfh();
                    $("#loginname").focus();
                }
            }
        });
    }
}

$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $("#to-recover").trigger("click");
    }
});

//登录校验
function check() {
    var chkphone = /^1[3|4|5|7|8]\d{9}$/;
    var loginphone = $("#loginphone");
    if (!chkphone.test(loginphone.val())) {
        loginphone.tips({
            side: 3,
            msg: '请正确输入手机号进行注册',
            bg: '#AE81FF',
            time: 2
        });
        loginphone.focus();
        loginphone.val('');
        return false;
    } else {
        loginphone.val(jQuery.trim(loginphone.val()));
    }
    if ($("#loginpassword").val() == "") {
        $("#loginpassword").tips({
            side: 2,
            msg: '密码不得为空',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#loginpassword").focus();
        return false;
    }
    if ($("#code").val() == "") {
        $("#code").tips({
            side: 1,
            msg: '验证码不得为空',
            bg: '#AE81FF',
            time: 3
        });
        showfh();
        $("#code").focus();
        return false;
    }

    return true;
}

function savePaw() {
    if (!$("#saveid").attr("checked")) {
        $.cookie('loginphone', '', {
            expires: -1
        });
        $.cookie('loginpassword', '', {
            expires: -1
        });
        $("#loginphone").val('');
        $("#loginpassword").val('');
    }
}

//记住密码
function saveCookie() {
    if ($("#saveid").attr("checked")) {
        $.cookie('loginphone', $("#loginphone").val(), {
            expires: 7
        });
        $.cookie('loginpassword', $("#loginpassword").val(), {
            expires: 7
        });
    }
}

jQuery(function () {
    var loginphone = $.cookie('loginphone');
    var loginpassword = $.cookie('loginpassword');
    if (typeof(loginphone) != "undefined"
        && typeof(loginpassword) != "undefined") {
        $("#loginphone").val(loginphone);
        $("#loginpassword").val(loginpassword);
        $("#saveid").attr("checked", true);
        $("#code").focus();
    }
});

//登录注册忘记密码页面切换
function changepage(value) {
    if (value == 1) {
        $("#windows1").show();
        $("#windows2").hide();
        $("#windows3").hide();
    } else if (value == 2) {
        $("#windows1").hide();
        $("#windows2").show();
        $("#windows3").hide();
    }else {
        $("#windows1").hide();
        $("#windows2").hide();
        $("#windows3").show();
    }
}

//注册验证
function rcheck() {
    // 手机号的正则表达式
    var chkphone = /^1[3|4|5|7|8]\d{9}$/;
    var resphone = $("#resphone");
    if (!chkphone.test(resphone.val())) {
        resphone.tips({
            side: 3,
            msg: '请正确输入手机号进行注册',
            bg: '#AE81FF',
            time: 2
        });
        resphone.focus();
        resphone.val('');
        return false;
    } else {
        resphone.val(jQuery.trim(resphone.val()));
    }
    if ($("#respassword").val() == "") {
        $("#respassword").tips({
            side: 3,
            msg: '请输入密码',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#respassword").focus();
        return false;
    }
    if ($("#respassword").val().length < 6 || $("#respassword").val().length > 10) {
        $("#respassword").tips({
            side: 3,
            msg: '密码长度为6-10位',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#respassword").focus();
        return false;
    }
    if ($("#chkpwd").val() != $("#respassword").val()) {
        $("#chkpwd").tips({
            side: 3,
            msg: '两次密码不相同',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#chkpwd").focus();
        return false;
    }
    if ($("#name").val() == "") {
        $("#name").tips({
            side: 3,
            msg: '请输入住客姓名',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#name").focus();
        return false;
    }
    if ($("#name").val().length < 2 || $("#name").val().length > 8) {
        $("#name").tips({
            side: 3,
            msg: '姓名长度不正确',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#name").focus();
        return false;
    }
    if ($("#EMAIL").val() == "") {
        $("#EMAIL").tips({
            side: 3,
            msg: '输入邮箱',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#EMAIL").focus();
        return false;
    } else if (!ismail($("#EMAIL").val())) {
        $("#EMAIL").tips({
            side: 3,
            msg: '邮箱格式不正确',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#EMAIL").focus();
        return false;
    }
    if ($("#rcode").val() == "") {
        $("#rcode").tips({
            side: 1,
            msg: '验证码不得为空',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#rcode").focus();
        return false;
    }
    return true;
}

//提交注册
function register() {
    if (rcheck()) {
        var phone = $("#resphone").val();
        var password = $("#respassword").val();
        var name = $("#name").val();
        var email = $("#EMAIL").val();
        var rcode = $("#rcode").val();
        var data = "phone="+phone+"&password="+password+"&name="+name+"&email="+email+"&rcode="+rcode;
        $.ajax({
            type: "POST",
            url: 'register',
            data: data,
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.code == 0) {
                    $("#windows2").hide();
                    $("#windows1").show();
                    $("#loginbox").tips({
                        side: 1,
                        msg: '注册成功,请登录',
                        bg: '#68B500',
                        time: 3
                    });
                } else if (data.code == 501) {
                    $("#resphone").tips({
                        side: 1,
                        msg: "手机号不能为空",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#resphone").focus();
                } else if (data.code == 502) {
                    $("#resphone").tips({
                        side: 1,
                        msg: "该手机号格式不正确，请重新输入",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#resphone").focus();
                } else if (data.code == 504) {
                    $("#EMAIL").tips({
                        side: 1,
                        msg: "邮箱格式不正确，请重新输入",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#EMAIL").focus();
                } else if (data.code == 505) {
                    $("#rcode").tips({
                        side: 1,
                        msg: "验证码不能为空",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#rcode").focus();
                } else if (data.code == 506) {
                    $("#rcode").tips({
                        side: 1,
                        msg: "验证码错误，请重新输入",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#rcode").focus();
                } else if (data.code == 507) {
                    $("#resphone").tips({
                        side: 1,
                        msg: "该手机号已注册，请登录",
                        bg: '#FF5080',
                        time: 5
                    });
                    showfh();
                    $("#resphone").focus();
                } else if (data.code == 508) {
                    $("#loginbox").tips({
                        side : 1,
                        msg : '注册失败，请重试 ...',
                        bg : '#68B500',
                        time : 10
                    });
                    showfh();
                }
            }
        });
    }
}


//忘记密码效验
function fcheck() {
    // 手机号的正则表达式
    var chkphone = /^1[3|4|5|7|8]\d{9}$/;
    var forgetPhone = $("#forgetPhone");
    if (!chkphone.test(forgetPhone.val())) {
        forgetPhone.tips({
            side: 3,
            msg: '请正确输入手机号进行验证',
            bg: '#AE81FF',
            time: 2
        });
        forgetPhone.focus();
        forgetPhone.val('');
        return false;
    } else {
        forgetPhone.val(jQuery.trim(forgetPhone.val()));
    }
    if ($("#forgetPassword").val() == "") {
        $("#forgetPassword").tips({
            side: 3,
            msg: '请输入新密码',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#forgetPassword").focus();
        return false;
    }
    if ($("#forgetPassword").val().length < 6 || $("#forgetPassword").val().length > 10) {
        $("#forgetPassword").tips({
            side: 3,
            msg: '密码长度为6-10位',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#forgetPassword").focus();
        return false;
    }
    if ($("#checkForgetPassword").val() != $("#forgetPassword").val()) {
        $("#checkForgetPassword").tips({
            side: 3,
            msg: '两次密码不相同',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#checkForgetPassword").focus();
        return false;
    }
    if ($("#forgetName").val() == "") {
        $("#forgetName").tips({
            side: 3,
            msg: '请输入验证姓名',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#forgetName").focus();
        return false;
    }
    if ($("#forgetName").val().length < 2 || $("#forgetName").val().length > 8) {
        $("#forgetName").tips({
            side: 3,
            msg: '验证姓名长度不正确',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#forgetName").focus();
        return false;
    }
    if ($("#fcode").val() == "") {
        $("#fcode").tips({
            side: 1,
            msg: '验证码不得为空',
            bg: '#AE81FF',
            time: 2
        });
        showfh();
        $("#fcode").focus();
        return false;
    }
    return true;
}

//忘记密码
function forgetPassword() {
    if (fcheck()) {
        var data = $("#ForgetPasswordForm").serialize();
        $.ajax({
            type: "POST",
            url: 'forgetPassword',
            data: data,
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.code == 0) {
                    $("#loginbox").tips({
                        side: 1,
                        msg: '重设密码成功,请登录',
                        bg: '#68B500',
                        time: 3
                    });
                    window.location.href = "login"
                } else if (data.code == 700) {
                    $("#forgetPhone").tips({
                        side: 1,
                        msg: '验证手机号和姓名不匹配，请重新验证',
                        bg: '#68B500',
                        time: 3
                    });
                    showfh();
                } else if (data.code == 701) {
                    $("#fcode").tips({
                        side: 1,
                        msg: '验证码不正确',
                        bg: '#AE81FF',
                        time: 2
                    });
                    showfh();
                    $("#fcode").focus();
                } else if (data.code == 702) {
                    $("#forgetPassword").tips({
                        side: 1,
                        msg: "重设密码不能和原密码重复",
                        bg: '#FF5080',
                        time: 2
                    });
                    showfh();
                    $("#forgetPassword").focus();
                }
            }
        });
    }
}

//邮箱格式校验
function ismail(mail) {
    return (new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
}
//js  日期格式