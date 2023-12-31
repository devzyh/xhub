import {createApp} from 'vue'

import Cookies from 'js-cookie'

import ElementPlus from 'element-plus'
import locale from 'element-plus/lib/locale/lang/zh-cn' // 中文语言
import 'element-plus/theme-chalk/display.css'

import '@/assets/styles/index.scss' // global css
import App from './App'
import store from './store'
import router from './router'
import directive from './directive' // directive
// 注册指令
import plugins from './plugins' // plugins
import {download} from '@/utils/request'

// svg图标
import 'virtual:svg-icons-register'
import SvgIcon from '@/components/icon'
import elementIcons from '@/components/icon/svgIcon'

import './permission' // permission control
import {useDict} from '@/utils/dict'
import {addDateRange, handleTree, parseTime, resetForm, selectDictLabel, selectDictLabels} from '@/utils/common'

// 分页组件
import Pagination from '@/components/pagination'
// 自定义表格工具组件
import RightToolbar from '@/components/view/right'
// 文件上传组件
import FileUpload from "@/components/upload/file"
// 图片上传组件
import ImageUpload from "@/components/image/upload"
// 图片预览组件
import ImagePreview from "@/components/image/preview"
// 自定义树选择组件
import TreeSelect from '@/components/select/tree'
// 字典标签组件
import DictTag from '@/components/dict/tag'

const app = createApp(App)

// 全局方法挂载
app.config.globalProperties.useDict = useDict
app.config.globalProperties.download = download
app.config.globalProperties.parseTime = parseTime
app.config.globalProperties.resetForm = resetForm
app.config.globalProperties.handleTree = handleTree
app.config.globalProperties.addDateRange = addDateRange
app.config.globalProperties.selectDictLabel = selectDictLabel
app.config.globalProperties.selectDictLabels = selectDictLabels

// 全局组件挂载
app.component('DictTag', DictTag)
app.component('Pagination', Pagination)
app.component('TreeSelect', TreeSelect)
app.component('FileUpload', FileUpload)
app.component('ImageUpload', ImageUpload)
app.component('ImagePreview', ImagePreview)
app.component('RightToolbar', RightToolbar)

app.use(router)
app.use(store)
app.use(plugins)
app.use(elementIcons)
app.component('svg-icon', SvgIcon)

directive(app)

// 使用element-plus 并且设置全局的大小
app.use(ElementPlus, {
    locale: locale,
    // 支持 large、default、small
    size: Cookies.get('size') || 'default'
})

app.mount('#app')
