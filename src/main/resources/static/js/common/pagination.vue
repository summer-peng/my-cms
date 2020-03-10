<template>
<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item">
			<a class="page-link"
					aria-label="Previous"
					@click="changePage(currentPage - 1)">
				<span aria-hidden="true">&laquo;</span>
				<span class="sr-only">Previous</span>
			</a>
		</li>
		<template v-if="currentPage < 6">
			<li v-for="n in totalPage"
					v-if="n<= 6" class="page-item"
					:class="{active: currentPage == n}"
					@click="changePage(n)">
					<a class="page-link">{{n}}</a>
			</li>
			<template v-if="totalPage > 6">
				<li class="paging-ellipsis">....</li>
				<li @click="changePage(totalPage)">
					<a class="page-link">{{totalPage}}</a>
				</li>
			</template>
		</template>
		<template v-else-if="currentPage > (totalPage - 5)">
			<li @click="changePage(1)">
				<a class="page-link">1</a>
			</li>
			<li class="paging-ellipsis">...</li>
			<li v-for="n in totalPage"
					v-if="n > totalPage-6"
					class="page-item"
					@click="changePage(n)"
					:class="{active: currentPage == n}">
					<a class="page-link">{{n}}</a>
			</li>
		</template>
		<template v-else>
			<li class="page-item" @click="changePage(1)">
				<a class="page-link">1</a>
			</li>
			<li class="paging-ellipsis">...</li>
			<li v-for="n in totalPage"
					v-if="Math.abs(n - currentPage) < 3"
					class="page-item"
					:class="{active: currentPage == n}"
					@click="changePage(n)">
				<a class="page-link">{{n}}</a>
			</li>
			<li class="paging-ellipis">...</li>
			<li class="page-item" @click="changePage(totalPage)">
				<a class="page-link">{{totalPage}}</a>
			</li>
		</template>
	<li class="page-item">
		<a class="page-link"
				aria-label="Next"
				@click="changePage(currentPage + 1)">
			<span aria-hidden="true">&raquo;</span>
			<span class="sr-only">Next</span>
		</a>
	</li>
	</ul>
</nav>
</template>
<script>
	export default {
		props: {
			currentPage: {
				type: Number,
				default: 1
			},
			totalPage: {
				type: Number,
				default: 1
			}
		},
		methods: {
			changePage: function(page){
				if(page <= 0){
					page = 1;
				}

				if(page > this.totalPage){
					page = this.totalPage;
				}

				this.$emit("changePage", page);
			}
		}
	}
</script>
