<template>
	<carousel :per-page="1" :mouse-drag="false">
		<slide>
			Slide 1 Content
		</slide>
		<slide>
			Slide 2 Content
		</slide>
	</carousel>
</template>
<script>
	import { Carousel, Slide } from "vue-carousel";
	export default {
		components: {Carousel, Slide},
		data(){
			return {
			}
		}
	}
</script>
<style scoped >
.VueCarousel-slide {
	  position: relative;
	  background: #42b983;
	  color: #fff;
	  font-family: Arial;
	  font-size: 24px;
	  text-align: center;
	  min-height: 100px;
	}

	.label {
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  transform: translate(-50%, -50%);
	}
</style>
