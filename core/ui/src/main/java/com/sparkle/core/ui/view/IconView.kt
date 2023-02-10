package com.sparkle.core.ui.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SentimentDissatisfied
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sparkle.core.ui.R
import com.sparkle.core.ui.Spacing
import com.sparkle.core.ui.SparkleTheme
import com.sparkle.core.ui.FontSize

@Composable
fun IconView(
    icon: ImageVector,
    @StringRes label: Int,
    modifier: Modifier
) {
    ConstraintLayout(modifier) {
        val (iconRef, textRef) = createRefs()

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .width(72.dp)
                .height(72.dp)
                .constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = stringResource(id = label),
            fontSize = FontSize.medium,
            modifier = Modifier
                .wrapContentSize()
                .padding(Spacing.double)
                .constrainAs(textRef) {
                    top.linkTo(iconRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview
@Composable
fun IconViewPreview() {
    SparkleTheme {
        IconView(
            icon = Icons.Default.SentimentDissatisfied,
            label = R.string.error_message,
            modifier = Modifier.fillMaxSize()
        )
    }
}