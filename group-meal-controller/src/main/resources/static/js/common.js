var request = {
    pageName: 'currentPage' //页码的参数名称，默认：page
    , limitName: 'pageSize' //每页数据量的参数名，默认：limit
};

var response = {
    statusName: 'httpStatus' //数据状态的字段名称，默认：code
    , statusCode: 200 //成功的状态码，默认：0
    , msgName: 'msg' //状态信息的字段名称，默认：msg
    , countName: 'count' //数据总数的字段名称，默认：count
    , dataName: 'data' //数据列表的字段名称，默认：data
};