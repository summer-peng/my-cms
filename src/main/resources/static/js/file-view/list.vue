<template>
<table class="table">
	<thead>
		<tr>
			<td>流水號</td>
			<td>名稱</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>標題一</td>
		</tr>
		<tr>
			<td>2</td>
			<td>標題二</td>
		</tr>
	</tbody>
</table>
</template>

<script>
export default {
	data(){
		return {
			pageResult: {
				rows:[],
				totalpages: 10,
				currpage:1
			}
		}
	},
	mounted(){

	},
	methods(){

	}
}

</script>
