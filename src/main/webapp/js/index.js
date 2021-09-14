$(function (){
    $.ajax({
        "url":"check.do",
        "dataType":"JSON",
        "type":"POST",
        success:function (res){
            if (res.res==100){
                $("#lo").text(res.data.username)
                $("#lo").attr("href","userinfo.jsp")
            }
        }
    })
})