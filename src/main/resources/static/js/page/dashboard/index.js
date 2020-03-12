import Vue from "vue";

import Breadcrumbs from "../../common/breadcrumbs.vue";
import vuetify from "../../plugins/vuetify.js";
import Dashboard from "./dashboard.vue";

new Vue({
	 components:{Dashboard},
	 vuetify,
	}).$mount('#root')