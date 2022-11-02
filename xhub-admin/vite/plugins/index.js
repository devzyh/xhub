import vue from '@vitejs/plugin-vue'

import createAutoImport from './autoImport'
import createSvgIcon from './svgIcon'
import createCompression from './compression'
import createSetupExtend from './setupExtend'

export default function createVitePlugins(viteEnv, isBuild = false) {
    const vitePlugins = [vue()]
    vitePlugins.push(createAutoImport())
	vitePlugins.push(createSetupExtend())
    vitePlugins.push(createSvgIcon(isBuild))
	isBuild && vitePlugins.push(...createCompression(viteEnv))
    return vitePlugins
}
