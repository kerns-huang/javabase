/**
 * Created by Administrator on 2017/9/25.
 */
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

var item = function (input, strategy) {
     var output = new Object(); // or var map = {};

    if (strategy.productIds == null) {
        output["errorCode"]= 1
        return output;
    }
    //
   if(!strategy.productIds.contains(input.id )) {
       output["errorCode"]= 2
       return output;
    }
    //指定特定的时间
    if (strategy.specifiedDays != null) {
        var time1 = new Date().Format("yyyy-MM-dd");
        if (!strategy.specifiedDays.contains(time1)) {
            output["errorCode"]= 3
            return output
        }
    }
    //指定每星期的星期几是参与的日子
    if (strategy.daysOfWeek != null) {
        var day = new Date(input.dishTimes).getDay()
        if (!strategy.daysOfWeek.contains(day)) {
            //不在指定的时间内
            output["errorCode"]= 4
            return output
        }
    }
    //如果时间段内的设置不为空。
    if (strategy.timeQuantumsOfDay != null) {
        // 不在时间内
        output["errorCode"]= 5
        return output
    }
    // 优惠限购数
    if (strategy.limitNum != null) {
        //如果限购了
        if (strategy.ruleType == 1) {
            output.put("price", input.price * strategy.discount);
        }
        else if (strategy.ruleType == 2) {
            output.put("price", input.price * strategy.discount);
        }
        output.totalPrice = output.price * input.num;
    }
    else {
        if (strategy.ruleType == 1) {
            output.price = input.price * strategy.discount;
        }
        else if (strategy.ruleType == 2) {
            output.price = strategy.fixPrice;
        }
        output.totalPrice = output.price * input.num;
    }
    return output
}