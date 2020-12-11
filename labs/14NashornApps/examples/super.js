var Exception = Java.type("java.lang.Exception");
var ExceptionAdapter = Java.extend(Exception);

var exception = new ExceptionAdapter("My Exception Message") {
    getMessage: function() {
        var _super_ = Java.super(exception);
        return _super_.getMessage().toUpperCase();
    }
}

try {
    throw exception;
} catch (ex) {
    print(exception);
}