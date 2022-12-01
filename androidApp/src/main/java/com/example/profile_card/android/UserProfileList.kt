import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.profile_card.android.AppBar
import com.example.profile_card.android.UserProfile
import com.example.profile_card.android.userProfileList

@Composable
fun   UserProfileList(userProfiles: List<UserProfile> = userProfileList, navController: NavController) {
    Scaffold(topBar = { AppBar(title = "User ProfileList", icon = Icons.Default.Home) { } }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                items(userProfiles) {userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController.navigate("user_details/${userProfile.id}")
                    }
                }
            }
        }
    }
}