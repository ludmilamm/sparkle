package dependencies

import AppLibs

object PresentationDependencies {

    val appLibs = listOf(
        AppLibs.appCompat,
        AppLibs.viewModel,
        AppLibs.viewModelCompose,
        AppLibs.composeToolingPreview,
        AppLibs.composeMaterial,
        AppLibs.composeMaterialIcon,
        AppLibs.composeActivity,
        AppLibs.composeNavigation,
        AppLibs.composeConstraintLayout,
        AppLibs.coil,
        AppLibs.hiltNavigationCompose,
        AppLibs.material
    )

    val debugLibs = listOf(
        AppLibs.composeTooling
    )
}