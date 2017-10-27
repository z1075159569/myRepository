var http = require('http');
var url = require('url');
var path = require('path');

//??server
var server = http.createServer(function(req, res) {
	//??????
	var pathname = url.parse(req.url).pathname;
	res.writeHead(200,{'Content-Type' : 'application/json;charset=utf-8'});
	//??http://localhost:8060/,????{?index":"??????"}
	if(pathname == '/') {
		res.end(JSON.stringify({"index":"欢迎来到首页"}));
	}
	//??http://localhost:8060/,????{"status":"UP"}
	else if(pathname = '/health.json') {
		res.end(JSON.stringify({"status":"UP"}));
	}
	//??????404
	else{
		res.end("404");
		}
});
//??????????
server.listen(8060, function() {
	console.log('listening on localhost:8060');
});
