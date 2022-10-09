package com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.ronalad.mavaroo.R
import com.ronalad.mavaroo.ui.theme.Independence
import com.ronalad.mavaroo.ui.theme.Linen
import com.ronalad.mavaroo.ui.theme.Snow

@Composable
fun MovieItem(
    title: String,
    image: String,
    type: String,
    rating: Double
) {
    Card(
        shape = RoundedCornerShape(CornerSize(16.dp)),
        elevation = 4.dp,
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF190933), Independence),
                        endY = 150f
                    )
                )
        ) {
            val (imageRef, titleRef, typeRef, starIconRef, ratingRef) = createRefs()

            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imageRef) {
                        top.linkTo(parent.top, margin = 12.dp)
                        start.linkTo(parent.start, margin = 12.dp)
                        bottom.linkTo(parent.bottom, margin = 12.dp)
                    }
                    .width(60.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(CornerSize(16.dp))),
                contentScale = ContentScale.Crop
            )

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W800,
                    color = Snow
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(titleRef) {
                        top.linkTo(imageRef.top)
                        start.linkTo(imageRef.end, margin = 12.dp)
                        end.linkTo(typeRef.end)
                        width = Dimension.fillToConstraints
                    }
            )

            Text(text = type, style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.W400,
                color = Linen
            ), modifier = Modifier.constrainAs(typeRef) {
                bottom.linkTo(imageRef.bottom)
                start.linkTo(imageRef.end, margin = 12.dp)
                end.linkTo(starIconRef.start, margin = 4.dp)
                width = Dimension.fillToConstraints
            })

            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.constrainAs(starIconRef) {
                    end.linkTo(ratingRef.start, margin = 4.dp)
                    bottom.linkTo(parent.bottom, margin = 12.dp)
                }
            )

            Text(text = rating.toString(), style = TextStyle(
                fontSize = 14.sp,
                color = Snow,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center
            ),
                modifier = Modifier.constrainAs(ratingRef) {
                    end.linkTo(parent.end, margin = 12.dp)
                    bottom.linkTo(starIconRef.bottom)
                    top.linkTo(starIconRef.top)
                }
            )

        }

    }
}

@Preview
@Composable
private fun PreviewMovieItem() {
    //MovieItem(title = "Test", "MyImage", "Movie", 7.8)
}