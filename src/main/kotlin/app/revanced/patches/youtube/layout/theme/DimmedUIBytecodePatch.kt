package app.revanced.patches.dimmedui

@Patch(
    name = "Dimmed UI",
    description = "Apply to make the texts look darker in the app.",
    compatiblePackages = [
        CompatiblePackage(
            "com.google.android.youtube",
            [
                "18.32.39",
                "18.37.36",
                "18.38.44",
                "18.43.45",
                "18.44.41",
                "18.45.43",
                "18.48.39",
                "18.49.37",
                "19.01.34",
                "19.02.39",
                "19.03.35",
                "19.03.36",
                "19.16.38",
                "19.16.39",
                "19.17.41",
                "19.18.41",
                "19.19.39",
                "19.21.34",
                "19.21.37",
                "19.21.39"
            ]
        )
    ]
)
object DimmedUIPatch : BytecodePatch() {
    override fun execute(context: BytecodeContext) {
        val isDarkMode = context.pageStyle == 1
        val textColor = if (isDarkMode) 0xFF909090.toInt() else 0xFF808080.toInt()
        
        context.resources.getString("lightTextColor").color = textColor
        context.resources.getString("darkTextColor").color = textColor
    }
}
