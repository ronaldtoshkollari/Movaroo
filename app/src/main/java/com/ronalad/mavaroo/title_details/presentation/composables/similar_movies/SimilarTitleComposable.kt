package com.ronalad.mavaroo.title_details.presentation.composables.similar_movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import coil.compose.AsyncImage
import com.ronalad.mavaroo.R

@Composable
fun SimilarTitleComposable(
    modifier: Modifier = Modifier,
    title: String,
    image: String,
    imDbRating: String
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(4.dp),
            elevation = 6.dp
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                modifier = Modifier
                    .width(164.dp)
                    .height(120.dp)
            )

        }

        Text(
            text = title, style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.SansSerif
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = imDbRating,
                style = TextStyle(
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )
            )

            Spacer(modifier = Modifier.width(4.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null
            )
        }
    }

}

@Preview
@Composable
private fun SimilarTitleComposablePreview() {
    SimilarTitleComposable(
        title = "John wick 4",
        image = "An image",
        imDbRating = "7.7"
    )
}