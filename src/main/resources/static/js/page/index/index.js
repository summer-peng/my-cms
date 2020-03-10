import Vue from "vue";
//import VueCarousel from "vue-carousel";

import Breadcrumbs from "../../common/breadcrumbs.vue";
import MainPage from "./main-page.vue";
new Vue({
	el: "#root",
	components:{MainPage, Breadcrumbs}
});
