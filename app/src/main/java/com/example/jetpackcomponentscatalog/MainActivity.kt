package com.example.jetpackcomponentscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val myOptions = getOptions(listOf("Ruben", "Ejemplo", "Pikachu"))

                    /*var show by remember {
                        mutableStateOf(false)
                    }

                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                        MyConfirmationDialog(
                            show = show,
                            onDismiss = { show = false })*/
                    CrossfadeExampleAnimation()
                }
            }
        }
    }
}

@Composable
fun MyDropdownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    var desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText, onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },
            Modifier.fillMaxWidth()
        ) {
            desserts.forEach { desserts ->
                DropdownMenuItem(text = { Text(text = desserts) }, onClick = {
                    expanded = false
                    selectedText = desserts
                })
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color.Red
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Badge(
                content = { Text("100") },
                containerColor = Color.Blue,
                contentColor = Color.Green
            )
        }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Estrella")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            contentColor = Color.Green,
            containerColor = Color.Red
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Aris",
                onClick = {
                    onItemSelected("Aris")
                }
            )
            Text(text = "Aris")
        }

        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ruben",
                onClick = {
                    onItemSelected("Ruben")
                }
            )
            Text(text = "Ruben")
        }

        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Pedro",
                onClick = {
                    onItemSelected("Pedro")
                }
            )
            Text(text = "Pedro")
        }

        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Juan",
                onClick = {
                    onItemSelected("Juan")
                }
            )
            Text(text = "Juan")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false,
            onClick = { /*TODO*/ },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            )
        )
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }

        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }

}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComponentsCatalogTheme {
        Divider()
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Cyan,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan,
            disabledCheckedTrackColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow
        )
    )
}

@Composable
fun MyPregressAdvance() {

    var statusProgress by rememberSaveable {
        mutableFloatStateOf(0.1f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = statusProgress)

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (statusProgress < 1.0f) {
                    statusProgress += 0.1f
                }
            }) {
                Text(text = "Incrementar")
            }
            Button(onClick = {
                if (statusProgress > 0.0f) {
                    statusProgress -= 0.1f
                }
            }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Blue
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            if (showLoading) {
                Text(text = "Desactivar")
            } else {
                Text(text = "Activar")
            }
        }
    }
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Ejemplo", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Hola")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp), label = { Text(text = "Holita") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Red
        )
    )
}

@Composable
fun MyTextFieldAdvance() {

    var myText by remember {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
        },
        label = { Text(text = "Introduce tu nombre") })

    Column(modifier = Modifier.fillMaxSize()) {

    }
}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Black)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}