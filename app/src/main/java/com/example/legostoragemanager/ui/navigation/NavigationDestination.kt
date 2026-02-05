package com.example.legostoragemanager.ui.navigation


interface NavigationDestination {
    /**
     * Thông tin để xác định các điểm điều hướng của composable của
     */
    val route: String

    /**
    * ID String Resource để hiện lên trên tiêu đề màn hình
    * */
    val titleRes: Int
}