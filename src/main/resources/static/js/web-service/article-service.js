export const getArticle = () => {
	return new Promise((resolve, reject) => {
		$.ajax({
			method: "POST",
			url: "/data/get-article",
		}).done(function(data) {
			resolve(data);
		})
		.fail(function(jqXHR, textStatus) {
			console.error(textStatus);
			resolve([]);
		});
	});
}

export const getPagedArticle = (currentPage, size) => {
	return new Promise((resolve, reject) => {
		$.ajax({
			method: "POST",
			url: "/data/get-paged-article",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				currentPage, size
			})
		}).done(function(data) {
			resolve(data);
		})
		.fail(function(jqXHR, textStatus) {
			console.error(textStatus);
			resolve({
				currentPage: 1,
				totalPage:1
			});
		});
	});
}

export const getName = () => {
	return new Promise((resolve, reject)=>{
		setTimeout(function(){
			resolve("Hello world!");
		}, 1000);
	});
}

export default {
	getArticle,
	getPagedArticle,
	getName
}
