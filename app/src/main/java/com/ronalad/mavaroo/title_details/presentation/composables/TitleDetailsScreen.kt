package com.ronalad.mavaroo.title_details.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.title_details.presentation.composables.actors.ActorsList
import com.ronalad.mavaroo.title_details.presentation.composables.similar_movies.SimilarTitleList
import com.ronalad.mavaroo.ui.theme.ChineseBlack
import com.ronalad.mavaroo.R

@Composable
fun TitleDetailsScreen(
    titleDetails: TitleDetails,
    isLoading: Boolean,
    errorMessage: String,
    onActorClick: (id: String) -> Unit,
    onSimilarTitleClick: (id: String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChineseBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        }

        if (titleDetails.errorMessage.isEmpty()) {
            TitleDetailsComposable(titleDetails = titleDetails)
        }

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage)
        }
    }
}

@Composable
private fun TitleDetailsComposable(
    modifier: Modifier = Modifier,
    titleDetails: TitleDetails
) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {

        val (filteredImageRef, imageRef, titleRef, totalTimeRef, typeRef,
            ratingRef, starImageRef, plotRef, crewRef, similarMoviesRef) = createRefs()

        AsyncImage(
            model = titleDetails.image,
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .graphicsLayer { alpha = 0.79f }
                .drawWithContent {
                    val colors = listOf(
                        Color.Black,
                        Color.Transparent
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstIn
                    )
                }
                .constrainAs(filteredImageRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            contentScale = ContentScale.FillWidth
        )

        AsyncImage(
            model = titleDetails.image,
            contentDescription = null,
            modifier = Modifier
                .width(164.dp)
                .height(250.dp)
                .constrainAs(imageRef) {
                    top.linkTo(filteredImageRef.bottom)
                    bottom.linkTo(filteredImageRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(text = titleDetails.fullTitle, style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 18.sp,
            color = Color.White,
        ),
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(imageRef.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 40.dp)
                end.linkTo(parent.end, margin = 40.dp)
            }
        )

        Text(
            text = titleDetails.runTime + " | R", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = Color.White.copy(alpha = 0.4f)
            ),
            modifier = Modifier.constrainAs(totalTimeRef) {
                top.linkTo(titleRef.bottom, margin = 16.dp)
                start.linkTo(titleRef.start)
                end.linkTo(titleRef.end)
            }
        )

        Text(
            text = titleDetails.genres, style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = Color.White.copy(alpha = 0.4f)
            ),
            modifier = Modifier.constrainAs(typeRef) {
                top.linkTo(totalTimeRef.bottom, margin = 8.dp)
                start.linkTo(titleRef.start)
                end.linkTo(titleRef.end)
            }
        )

        Text(
            text = titleDetails.imDbRating,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp,
                lineHeight = 18.sp,
                color = Color.White
            ), modifier = Modifier.constrainAs(ratingRef) {
                top.linkTo(typeRef.bottom, margin = 30.dp)
                start.linkTo(titleRef.start)
                end.linkTo(starImageRef.end)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(starImageRef) {
                    top.linkTo(ratingRef.top)
                    bottom.linkTo(ratingRef.bottom)
                    end.linkTo(parent.end, 8.dp)
                }
                .size(30.dp)
        )

        createHorizontalChain(
            ratingRef, starImageRef,
            chainStyle = ChainStyle.Packed
        )

    }

}