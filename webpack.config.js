const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const path = require("path");
const fs = require("fs");
const sourcePath = "./src/main/resources/static/js/page";
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const webpack = require('webpack');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

//let vueVersion = '';
//if(process.env['vue'] && process.env.vue.trim() === 'debug'){
//	vueVersion = 'vue.js';
//}else{
//	vueVersion = 'vue.min.js';
//}
//console.log("vueVersion:" + vueVersion);
let entry = {};

let srcFolders = fs.readdirSync(sourcePath);
console.log("start" + srcFolders.length);
if (srcFolders.length > 0) {
    for (let folder of srcFolders) {
        entry[folder] = [`${sourcePath}/${folder}/index.js`];
    }
}

Object.keys(entry).forEach((key, index) => {
    console.log(key + ":");
    console.log("========>" + entry[key]);
});

module.exports = {
    entry,
    module: {
        rules:[{
        	test: /\.vue$/,
        	loader: "vue-loader"
        },
        {
            test: /\.js$/,
            loader: "babel-loader"
        },
        {
            test: /\.css$/,
            //process.env.NODE_ENV !== "production" ? "vue-style-loader" : : MiniCssExtractPlugin.loader
            use: [MiniCssExtractPlugin.loader, "css-loader"],
          }
        ]
    },
    mode: "development",
    output: {
        filename: "[name].js",
        path: __dirname + "/src/main/resources/static/js-output",
    },
	resolve: {
		alias: {
			'vue$': __dirname + '/node_modules/vue/dist/vue.js'
		}
	},
    plugins: [
        new CleanWebpackPlugin(),
        new VueLoaderPlugin(),
        new MiniCssExtractPlugin({
        	filename: "[name].css"
        }),
        new webpack.SourceMapDevToolPlugin({
		  filename: '[name].js.map',
		  exclude: ['vendor.js']
		})
	],
	optimization: {
	splitChunks: {
		cacheGroups: {
			index: {
				name: 'index',
				test: /[\\/]node_modules[\\/].*\.vue$/,
				chunks: 'all',
				enforce: true,
			},
		},
	},
},
};
