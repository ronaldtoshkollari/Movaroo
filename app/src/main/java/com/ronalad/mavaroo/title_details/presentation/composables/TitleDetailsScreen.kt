package com.ronalad.mavaroo.title_details.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ronalad.mavaroo.R
import com.ronalad.mavaroo.common.composables.ExpandableText
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.title_details.presentation.composables.actors.ActorsList
import com.ronalad.mavaroo.title_details.presentation.composables.similar_movies.SimilarTitleList
import com.ronalad.mavaroo.title_details.presentation.viewmodel.TitleDetailsViewModel
import com.ronalad.mavaroo.ui.theme.ChineseBlack

@Composable
fun TitleDetailsScreen(
    navController: NavController,
    titleId: String?,
    titleDetailsViewModel: TitleDetailsViewModel = hiltViewModel()
) {

    val titleDetailsState by titleDetailsViewModel.titleDetailsState.collectAsState()
    val id = titleId ?: ""
    titleDetailsViewModel.getTitleDetails(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChineseBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (titleDetailsState.isLoading) {
            CircularProgressIndicator()
        }

        if (titleDetailsState.titleDetails.errorMessage.isEmpty() && titleDetailsState.titleDetails.id.isNotBlank()) {
            TitleDetailsComposable(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState()),
                titleDetails = titleDetailsState.titleDetails
            )
        }

        if (titleDetailsState.errorMessage.isNotEmpty()) {
            Text(text = titleDetailsState.errorMessage)
        }
    }
}

@Composable
private fun TitleDetailsComposable(
    modifier: Modifier = Modifier,
    titleDetails: TitleDetails
) {

    ConstraintLayout(modifier = modifier) {

        val (filteredImageRef, imageRef, titleRef, totalTimeRef, typeRef,
            ratingRef, starImageRef, plotTitleRef, plotRef, crewTitleRef, crewRef,similarTitlesTitleRef, similarTitlesRef) = createRefs()

        AsyncImage(
            model = titleDetails.image,
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .graphicsLayer { alpha = 0.75f }
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

        Text(
            text = "Synopsis", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color.White,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(plotTitleRef) {
                top.linkTo(ratingRef.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 18.dp)
            }
        )

        ExpandableText(
            text = titleDetails.plot, style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color.White.copy(alpha = 0.4f),
                fontWeight = FontWeight.W400
            ),
            modifier = Modifier.constrainAs(plotRef) {
                top.linkTo(plotTitleRef.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Cast & Crew", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color.White,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(crewTitleRef) {
                top.linkTo(plotRef.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 18.dp)
            }
        )

        ActorsList(
            actors = titleDetails.actorList,
            onClick = {},
            modifier = Modifier
                .constrainAs(crewRef) {
                    top.linkTo(crewTitleRef.bottom, margin = 2.dp)
                    start.linkTo(crewTitleRef.start)
                    end.linkTo(parent.end, margin = 18.dp)
                    width = Dimension.fillToConstraints
                },
            contentPadding = PaddingValues(top = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        )

        Text(
            text = "Similar Titles", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color.White,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(similarTitlesTitleRef) {
                top.linkTo(crewRef.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 18.dp)
            }
        )

        SimilarTitleList(
            similarTitles = titleDetails.similarTitles,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(similarTitlesRef) {
                    top.linkTo(similarTitlesTitleRef.bottom, margin = 2.dp)
                    start.linkTo(similarTitlesTitleRef.start)
                    end.linkTo(parent.end)
                },
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
    }

}