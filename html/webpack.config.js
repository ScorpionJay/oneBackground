
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {

	// 入口
	entry: "./index.js",
	
	// 输出
	output: {
        filename: "./bundle.js"
	},

	// 解决的文件
	resolve: {
        extensions: ['', '.js','.jsx','.scss','.jpg']
    },
	
	// 模块加载器
	module: {
        loaders: [
        	{ test: /\.css$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader") },
        	{ test: /\.scss$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader!sass-loader")},
            { test: /\.jsx|.js$/,exclude: /node_modules/, loader: 'babel-loader?presets[]=es2015&presets[]=react' },
            {
                test: /\.(jpe?g|png|gif|svg|ico)$/,
                loader: 'url?limit=8024&name=img/[name].[ext]'
            },
        ]
    },

    // Use the plugin to specify the resulting filename (and add needed behavior to the compiler)
    plugins: [
        new ExtractTextPlugin("css/main.css")
    ]

};