import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profile_card.android.AppBar
import com.example.profile_card.android.UserProfile
import com.example.profile_card.android.userProfileList

@Composable
fun UserProfileDetailsScreen(userId: Int, navController: NavController) {
    val userProfile = userProfileList.first { userProfile: UserProfile -> userId == userProfile.id }
    Scaffold(topBar = { AppBar(title = "User Profile Details", icon = Icons.Default.ArrowBack) {
        navController.navigateUp()
    } }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally) {
                // Profile Picture
                ProfilePicture(userProfile.pictureUrl, userProfile.status, 240.dp)
                // Profile Content
                ProfileContent(userProfile.name, userProfile.status, alignment = Alignment.CenterHorizontally)
            }
        }
    }
}