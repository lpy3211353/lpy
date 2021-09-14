$(function(){
    $.ajax({
        "url":"check.do",
        "dataType":"JSON",
        "type":"POST",
        success:function (res){
            if (res.res==100){
                $("#lo").attr("href","userinfo.jsp")
                location.href="userinfo.jsp"
            }
        }
    })
    $("#login_name").focus();
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#login_btn").click();
        }
    });

    $("#login_btn").click(function(){
        $.ajax({
            "url":"login.do",
            "data":$("#login_form").serialize(),
            "dataType":"json",
            "type":"POST",
            success:function (res){
                if (res.res==100){
                    console.log(res.data.username)
                    $("#lo").text(res.data.username)
                    location.href="index.jsp"
                    $("#lo").attr("href","userinfo.jsp")
                }else{
                    swal({
                        title:"登录失败",
                        type:"warning",
                        text:res.text,
                        confirmButtonColor: "#dd6b55"
                    })
                }

            }
        })
    })

    $("#register_btn").click(function (){
        $("#login_box").css("display","none")
        $("#register_box").css("display","block")
    })

    $("#register").click(function (){
        let password=$("#register_password").val()
        let repassword=$("#re_password").val()
        if (password!=repassword){
            swal({
                title:"注册失败",
                type:"warning",
                text:"两次密码不一样",
                confirmButtonColor: "#dd6b55"
            })
            return;
        }
        $.ajax({
            "url":"register.do",
            "data":$("#register_form").serialize(),
            "dataType":"json",
            "type":"POST",
            success:function (res){
                if (res.res==100){
                    swal({
                        title:"注册成功",
                        type:"success",
                        text:"注册成功，点击后跳转",
                        confirmButtonColor: "#2376b7"
                    })
                    $("#register_box").css("display","none")
                    $("#login_box").css("display","block")
                }else{
                    swal({
                        title:"注册失败",
                        type:"warning",
                        text:res.text,
                        confirmButtonColor: "#2376b7"
                    })
                }
            }
        })
    })

    $("#backlogin").click(function (){
        $("#register_box").css("display","none")
        $("#login_box").css("display","block")
    })

    function quit(){
            console.log("aaa")
            $.ajax({
                "url":"quit.do",
                "dataType":"json",
                "type":"POST",
                success:function (res){
                    console.log(res)
                }
            })
    }

});