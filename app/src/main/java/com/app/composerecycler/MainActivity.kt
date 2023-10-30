package com.app.composerecycler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.composerecycler.models.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerView()
        }
    }
}

@Composable
private fun RecyclerView() {
    val userList = dummyUsers()

    LazyColumn {
        items(userList) { user ->
            RecyclerItemView(user = user)
        }
    }

}

@Composable
fun RecyclerItemView(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = user.profilePic),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
            )
            Column {
                Text(text = user.name, Modifier.padding(start = 10.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .size(150.dp, 50.dp)
                        .padding(start = 10.dp, top = 10.dp)
                ) {
                    Text(
                        text = "Visit Profile",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecyclerPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        RecyclerView()
    }
}

private fun dummyUsers(): List<User> {
    val users = ArrayList<User>()
    users.add(User(R.drawable.ic_profile, "Yazdan"))
    users.add(User(R.drawable.ic_profile, "Husnain"))
    users.add(User(R.drawable.ic_profile, "Ali"))
    users.add(User(R.drawable.ic_profile, "Hassan"))
    users.add(User(R.drawable.ic_profile, "Faisal"))
    users.add(User(R.drawable.ic_profile, "Mubashar"))
    users.add(User(R.drawable.ic_profile, "Adnan"))
    return users
}