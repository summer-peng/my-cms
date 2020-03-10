<template>
<div>
	{{name}}
	<div v-for="m in article">
		<span class="test-span">{{m}}</span>
	</div>
	<input type="button" @click="testBindEvent" value="text bind click" />
	<input type="button" @click="testLoadingArticle()" value="test loading article" />
	<input type="button" @click="clear()" value="clear" />
</div>
</template>
<script>
import { getArticle, getPagedArticle, getName} from "../../web-service/article-service.js";
import ArticleService from "../../web-service/article-service.js";

export default {
	data(){
		return {
			name: "init value",
			article: [1, 2, 3, 4]
		}
	},
	mounted(){
		ArticleService.getName().then((name)=>{
			this.name = "mounted:" + name || "";
		});

	},
	methods: {
		testBindEvent: function(){
			$(".test-span").on("click", function(e){
				alert("test span");
			});
		},
		testLoadingArticle: function(){
			 getArticle().then((article)=>{
				 this.article = article || [];
			 });
		},
		clear: function(){
			this.article = [];
		}
	}
}
</script>