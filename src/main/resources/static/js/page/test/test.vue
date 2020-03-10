<template>
<div>
	{{name}}
	<input type="button" @click="testAjax()" value="text ajax" />
</div>
</template>
<script>
import { getArticle, getPagedArticle, getName} from "../../web-service/article-service.js";
import ArticleService from "../../web-service/article-service.js";

export default {
	data(){
		return {
			name: "init value",
			article: []
		}
	},
	mounted(){
		ArticleService.getName().then((name)=>{
			this.name = "mounted:" + name || "";
			return getArticle();
		}).then((article)=>{
			this.article = article || [];
		})
	},
	methods: {
		testAjax: function(){
			debugger;
			getName().then((name)=>{
				debugger;
				this.name = "name from click";
			});
		}
	}
}
</script>