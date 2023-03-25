import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.taqwa.plus.ui.SurahNames
import com.taqwa.plus.ui.SurahNames.listNumberOfSurh
import com.github.barteksc.pdfviewer.PDFView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Start(navController: NavController) {
    Scaffold(topBar = { TopBarQuran() }) {


        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                itemsIndexed(SurahNames.listSurhName) { index, name ->
                    CardInfo(name, index) {
                        navController.navigate(route = "1/${listNumberOfSurh[it]}")
                    }
                }
            }
        }
    }
}

@Composable
fun CardInfo(name: String, index: Int, click: (index: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    click(index)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(name)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PdfViewer(filePath: String?, navController: NavController) {
    val contex = LocalContext.current
    val pdfView = remember { PDFView(contex, null) }
    Scaffold(topBar = { TopBarBackQuran(navController) }) {
        Box(Modifier.fillMaxSize()) {
            AndroidView(
                { pdfView },
                Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                it.fromAsset(filePath!!).load()

            }
        }
    }
}

@Composable
fun TopBarQuran() {
    TopAppBar(title =

    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text("الفهرس")
        }


    })
}

@Composable
fun TopBarBackQuran(navController: NavController) {
    TopAppBar(title = {}, navigationIcon = {
        IconButton(onClick = { navController.navigateUp() }) {

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }
    })


}