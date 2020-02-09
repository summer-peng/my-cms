const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const path = require("path");
const fs = require("fs");
const sourcePath = "./src/main/resources/js";

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

const outputPath = path.resolve(__dirname, "/src/main/resources/js-output");
console.log(`output:${outputPath}`);

module.exports = {
    entry,
/*    module: {
        rules:[{
            test : /\.(jsx|js)$/,
            exclude : /(node_modules|taiwantrade-profile)/,
            use: {
                loader: 'babel-loader',
                options: {
                    presets: ['babel-preset-env']
                }
            }
        }]
    },*/
    mode: "development",
    output: {
        filename: "[name].js",
        path: __dirname + "/src/main/resources/js-output",
    },
    plugins: [
        new CleanWebpackPlugin()
    ]
};
