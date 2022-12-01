import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.profile_card.android.R
import com.example.profile_card.android.UserProfile

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable { clickAction.invoke() }
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
        backgroundColor = Color.White,
        elevation = 8.dp) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            // Profile Picture
            ProfilePicture(userProfile.pictureUrl, userProfile.status)
            // Profile Content
            ProfileContent(userProfile.name, userProfile.status)
        }

    }
}

@Composable
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, size: Dp = 72.dp) {
    Card(
        shape = CircleShape,
        elevation = 4.dp,
        border = BorderStroke(width = 1.dp, color = if(onlineStatus){Color.Green} else {MaterialTheme.colors.primary}),
        modifier = Modifier.padding(16.dp)) {
        // Hint the id is the file path
//        Image(
//            painter = painterResource(id = drawableId),
//            contentScale = ContentScale.Crop,
//            contentDescription = "Profile Image",
//            modifier = Modifier.size(72.dp))
        AsyncImage(
            model = pictureUrl,
            contentDescription = "Random Image",
            modifier = Modifier.size(size),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal = Alignment.Start) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(), horizontalAlignment = alignment) {
        CompositionLocalProvider(LocalContentAlpha provides if(onlineStatus) {1f} else {ContentAlpha.medium} ) {
            Text(text = userName,
                style = MaterialTheme.typography.h5)
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = if (onlineStatus) {
                "Online"
                                          } else {
                                                 "Offline"
                                                 },
                style = MaterialTheme.typography.body2)
        }

    }
}