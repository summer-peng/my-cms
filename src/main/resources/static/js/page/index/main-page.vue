<template>
	<div class="carousel-area">
		<div class="custom-vue-carousel">
			<h3>vue carousel</h3>
			<custom-vue-carousel></custom-vue-carousel>
		</div>
		<div class="slick-carousel">
			<h3>jquery slick</h3>
			<jquery-slick></jquery-slick>
		</div>
	</div>
</template>
<script>
import CustomVueCarousel from "./custom-vue-carousel.vue";
import JquerySlick from "./jquery-slick.vue";

export default {
	components: {CustomVueCarousel, JquerySlick},
	data(){
		return {
		}
	},
	mounted(){
	},
	methods: {
	}
}
</script>
