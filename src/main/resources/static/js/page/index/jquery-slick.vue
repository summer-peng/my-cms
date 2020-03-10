<template>
	<div class="my-slick">
		<div class="slick-content">
			<h3>Your content 1</h3>
		</div>
		<div class="slick-content">
			<h3>Your content 2</h3>
		</div>
		<div class="slick-content">
			<h3>Your content 3</h3>
		</div>
	</div>
</template>
<script>
export default {
	mounted() {
		$(this.$el).slick({
		  infinite: true,
		  dots: true,
		  speed: 3000
		});
	}
}
</script>
