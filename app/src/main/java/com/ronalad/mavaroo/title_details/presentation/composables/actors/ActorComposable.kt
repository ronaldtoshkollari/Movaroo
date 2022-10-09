package com.ronalad.mavaroo.title_details.presentation.composables.actors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.ronalad.mavaroo.R
import com.ronalad.mavaroo.ui.theme.Independence
import com.ronalad.mavaroo.ui.theme.Snow

@Composable
fun ActorComposable(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    character: String
) {
    ConstraintLayout(
        modifier = modifier
    ) {

        val (imageRef, nameRef, characterRef) = createRefs()

        Surface(
            shape = CircleShape,
            color = Snow,
            modifier = Modifier
                .size(48.dp)
                .constrainAs(imageRef) {
                    start.linkTo(parent.start, margin = 20.dp)
                    top.linkTo(parent.top, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background)
            )
        }

        Text(
            text = name, style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.constrainAs(nameRef) {
                start.linkTo(imageRef.end, margin = 12.dp)
                top.linkTo(imageRef.top)
                bottom.linkTo(imageRef.bottom)
                end.linkTo(characterRef.start, margin = 4.dp)
                width = Dimension.fillToConstraints
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = character, style = TextStyle(
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 12.sp,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(characterRef) {
                top.linkTo(parent.top, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
                end.linkTo(parent.end, margin = 20.dp)
                width = Dimension.fillToConstraints
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ActorPreview() {

    ActorComposable(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Independence),
        image = "An Image",
        name = "Keanu Reeves",
        character = "JOHN WICK"
    )

}