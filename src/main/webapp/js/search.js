$(function(){
    $.ajax({
        "url":"check.do",
        "dataType":"JSON",
        "type":"POST",
        success:function (res){
            if (res.res==100){
                console.log(res.data)
                $("#lo").text(res.data.username)
                $("#lo").attr("href","userinfo.jsp")
            }
        }
    })
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#search").click();
            }
        });
});