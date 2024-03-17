package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinesscardApp()
                }
            }
        }
    }
}

@Composable
fun BusinesscardApp() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF467c48))
    ) {
        Row(Modifier.weight(1f)) {
            NameAndTitle(
                imagePainter = painterResource(R.drawable.android_logo),
                name = stringResource(R.string.name),
                jobTitle = stringResource(R.string.job_title)
            )
        }
        Row(
            Modifier
                .weight(1f)
                .padding(70.dp)
        ) {
            ContactDetails(
                phoneIcon = Icons.Default.Phone,
                phone = stringResource(R.string.phone_number),
                shareIcon = Icons.Default.Share,
                linkedIn = stringResource(R.string.linkedIn),
                emailIcon = Icons.Default.Email,
                email = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun NameAndTitle(
    imagePainter: Painter,
    name: String,
    jobTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier
                .size(100.dp)
                .background(
                    Color.DarkGray
                )
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = jobTitle,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun ContactDetails(
    phoneIcon: ImageVector,
    phone: String,
    shareIcon: ImageVector,
    linkedIn: String,
    emailIcon: ImageVector,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = phoneIcon,
                contentDescription = null,
                modifier.padding(end = 8.dp)
            )
            Text(
                text = phone
            )
        }
        Row(
            modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = shareIcon,
                contentDescription = null,
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = linkedIn
            )
        }
        Row(
            modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = emailIcon,
                contentDescription = null,
                modifier.padding(end = 8.dp)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinesscardApp()
    }
}