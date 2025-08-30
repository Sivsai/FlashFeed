package com.littlelemon.appsnews.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.littlelemon.appsnews.R
import com.littlelemon.appsnews.data.entity.Article

@Composable
fun Loader(){
    Column(modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    { CircularProgressIndicator(
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp)
        , color = Color.White
    )  }

}
@Composable
fun TextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp),text = textValue, style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF808000)

        )
    )


}
@Composable
fun NewsRowComponent(page:Int,article: Article) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color.White)

        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(240.dp),
                model = article.urlToImage,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
            Spacer(modifier = Modifier.size(20.dp))

            HeadingTextComponent(article.title ?: "")

            Spacer(modifier = Modifier.size(10.dp))

            TextComponent(article.description ?: "")

//        Spacer(modifier = Modifier.size(10.dp))

            HyperLinkText(article.url)

            Spacer(modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.weight(1f))

            AuthorDetailsComponent(article.author, article.source.name)


        }


}
@Composable
fun HeadingTextComponent(textValue: String,centerAligned: Boolean = false){
 Text(text = textValue,
     modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp),
     style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
     color = Color.Black,
     textAlign = if(centerAligned) TextAlign.Center else TextAlign.Start
     )


}
@Composable
fun AuthorDetailsComponent(authorName: String?,sourceName: String?) {

    Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 24.dp)){

        authorName?.also {
            Text(authorName,color = Color.Black)
        }
        Spacer(modifier = Modifier.weight(1f))
        sourceName?.also {
                Text(sourceName,color = Color.Black)
        }
    }
}
@Composable
fun EmptyState(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(R.drawable.empty),
            contentDescription = null
        )
        HeadingTextComponent(textValue = "Currently no Articles are present . Try after few minutes!!!",true)


    }
}
@Composable
fun HyperLinkText(url:String){
    BasicText(
        buildAnnotatedString {

            withLink(
                LinkAnnotation.Url(
                    url,
                    TextLinkStyles(style = SpanStyle(color = Color.Blue)),
                )
            ) {
                append("Read More")
            }
        }
    )
}