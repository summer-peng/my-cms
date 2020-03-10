<template>
	<time>{{formatedTime}}</time>
</template>

<script>
import moment from "moment";

export default {
	props: ["time"],
	computed: {
		formatedTime: function(){
			let customTime = moment(this.time).format("YYYY/MM/DD hh:mm:ss");
			return customTime;
		}
	}
}
</script>
