package app.revanced.patches.dimmedui

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch


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
                "19.04.36",
                "19.04.37",
                "19.05.36",
                "19.07.39",
                "19.07.40",
                "19.08.36",
                "19.10.37",
                "19.11.38",
                "19.11.39",
                "19.11.43",
                "19.12.41",
                "19.13.37",
                "19.14.40",
                "19.14.42",
                "19.14.43",
                "19.15.36",
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
object DimmedUIBytecodePatch : BytecodePatch() {
    override fun execute(context: BytecodeContext) {
        val isDarkMode = context.isNightModeEnabled() // Check if in dark theme

        val textColor = if (isDarkMode) Color.parseColor("#909090") else Color.parseColor("#808080")

        // Adjust the following code to locate the text color resources in the YouTube app
        val lightTextColorId = context.getResources().getIdentifier("light_text_color", "color", context.getPackageName())
        val darkTextColorId = context.getResources().getIdentifier("dark_text_color", "color", context.getPackageName())

        context.getResources().setColor(lightTextColorId, textColor) // Set color for light theme text
        context.getResources().setColor(darkTextColorId, textColor) // Set color for dark theme text
    }
}
