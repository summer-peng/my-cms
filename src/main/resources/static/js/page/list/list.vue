<template>
	<no-result-found v-if="loading == false && pageResult.rows.length == 0">
	</no-result-found>
	<div v-else>
		<div class="list-group">
			<a v-for="row in pageResult.rows" class="list-group-item list-group-item-action">
				<div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">{{row.title}}</h5>
					<small>
						<span>Post date:</span>
						<custom-time :time="row.postDate"></custom-time>
					</small>
				</div>
				<p class="mb-1">{{row.description}}</p>
				<small>Created by {{row.author}}</small>
			</a>
			<a href="#" class="list-group-item list-group-item-action">
				<div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">List group item heading</h5>
					<small>3 days ago</small>
				</div>
				<p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				<small>Donec id elit non mi porta.</small>
			</a>
		</div>
		<pagination :totalPage="pageResult.totalPage"
							:currentPage="pageResult.currentPage"
							@changePage="changePage">
		</pagination>
	</div>
</template>

<script>
import { getArticle, getPagedArticle } from "../../web-service/article-service.js";
import NoResultFound from "../../common/no-result-found.vue";
import Pagination from "../../common/pagination.vue";
import CustomTime from "../../common/time.vue";

export default {
	components: {NoResultFound, Pagination, CustomTime},
	data(){
		return {
			pageResult: {
				rows:[],
				totalPage: 10,
				currentPage:1
			},
			loading: true
		}
	},
	mounted(){
		getPagedArticle(1, 10).then((data)=>{
			this.pageResult = data || [];
			this.loading = false;
		});
	},
	methods: {
		changePage: function(page){
			this.loading = true;
			getPagedArticle(page, this.pageResult.size).then((data)=>{
				this.pageResult = data || {
					rows:[],
					totalPage: 10,
					currentPage:1
				};
				this.loading = false;
			});
		}
	}
}

</script>
