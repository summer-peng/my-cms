<template>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb custom-breadcrumb">
			<li class="breadcrumb-item active" aria-current="page">
				<a href="/">Home</a>
			</li>
			<li v-for="title in titleList" class="breadcrumb-item" aria-current="page">
				{{title}}
			</li>
		</ol>
	</nav>
</template>
<script>
export default {
	props: {
		titleList: {
			type: Array,
			default: function(){
				return [];
			}
		}
	}
}
</script>
