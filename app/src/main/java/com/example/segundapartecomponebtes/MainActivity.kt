package com.example.segundapartecomponebtes

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.segundapartecomponebtes.ui.theme.SEgundaParteComponebtesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SEgundaParteComponebtesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var selected by rememberSaveable {
                        mutableStateOf("Radio 1")
                    }

                    MyRadioButtonListState(name = selected, { selected = it })


                    /*
                                        // my checkbox con estados
                                        Column {

                                            MyTristatusCheckBox()


                                            var estado by rememberSaveable {
                                                mutableStateOf(false)
                                            }
                                            val checkInfo = CheckInfo(titulo = "Ejemplo 1",
                                                selected = estado,
                                                onCheckedChange = { estado = it })

                                            MycCheckBoxConTextoCompleto(checkInfo = checkInfo)
                                            Text(text = estado.toString())


                                            val myOptions = getOptions(titulos = listOf("uno", "dos", "tres"))
                                            myOptions.forEach {
                                                MycCheckBoxConTextoCompleto(checkInfo = it)
                                            }
                                            Text(text = myOptions.get(0).selected.toString())
                                        }

                                        /////////////////////////////
                    */

                    //Greeting("Android")
                    //MyRadioButton()
                    //MyRadioButtonList()
                }
            }
        }
    }
}


@Composable
fun MyRadioButtonListState(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = name == "Radio 1", onClick = { onItemSelected("Radio 1") })
            Text(text = "Radio 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 2", onClick = { onItemSelected("Radio 2") })
            Text(text = "Radio 2")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 3", onClick = { onItemSelected("Radio 3") })
            Text(text = "Radio 3")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 4", onClick = { onItemSelected("Radio 4") })
            Text(text = "Radio 4")
        }
        Text(text = name)


    }
}


@Composable
fun MyRadioButtonList() {
    var selected by rememberSaveable {
        mutableStateOf("Radio 1")
    }
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = selected == "Radio 1", onClick = { selected = "Radio 1" })
            Text(text = "Radio 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Radio 2", onClick = { selected = "Radio 2" })
            Text(text = "Radio 2")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Radio 3", onClick = { selected = "Radio 3" })
            Text(text = "Radio 3")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Radio 4", onClick = { selected = "Radio 4 " })
            Text(text = "Radio 4")
        }
        Text(text = selected)


    }
}


@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(
            selected = false, onClick = { },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.DarkGray
            )
        )
        Text(text = "Radio 1")
    }
}


@Composable
fun getOptions(titulos: List<String>): List<CheckInfo> {
    return titulos.map {
        var estado by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            titulo = it,
            selected = estado,
            onCheckedChange = { estado = it })
    }
}

@Composable
fun MycCheckBoxConTextoCompleto(checkInfo: CheckInfo) {
    Row(

        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                checkmarkColor = Color.Green
            )
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = checkInfo.titulo)
    }

}

@Composable
fun MyButtonExample() {
    var enabled1 by rememberSaveable { mutableStateOf(true) }
    var enabled2 by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Button(
            onClick = {
                enabled1 = false
                enabled2 = true
            },
            enabled = enabled1,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Green
            ),
            border = BorderStroke(5.dp, Color.Magenta),
            shape = CircleShape,
            //shape = MaterialTheme.shapes.small
            //shape = MaterialTheme.shapes.extraLarge
            //shape = MaterialTheme.shapes.medium
            modifier = Modifier.size(50.dp)  // al tener el mismo ancho que alto, el boton es totalmente redondo
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Text(text = " Pulsar")
        }


        //////////////

        OutlinedButton(
            onClick = {
                enabled2 = false
                enabled1 = true
            },
            enabled = enabled2,
            modifier = Modifier.padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Red

            )
        ) {
            Text("Pulsar")
        }


        ////////////

        TextButton(onClick = { }) {
            Text(text = "Pulsar")

        }
    }
}


@Composable
fun MyImageExample() {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Descripción imagen",

        )
    Image(
        painter = painterResource(id = R.drawable.nosferatu),
        contentDescription = "Descripción imagen",
        alpha = .5f  //opacidad
    )


}

@Composable
fun MyCircularImageExample() {


    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Descripción imagen",
        // modifier = Modifier.clip(RoundedCornerShape(25f))

        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Blue, CircleShape)
    )


}


// Es parte de material Design 24x24
@Composable
fun MyIcon() {
    Column {

        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Icono",
            tint = Color.Red
        )

        Icon(
            imageVector = Icons.Rounded.Cancel,
            contentDescription = "Icono",
            tint = Color.Blue
        )
    }

}


@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 15.dp)
        LinearProgressIndicator(
            Modifier.padding(top = 40.dp),
            color = Color.Blue,
            trackColor = Color.Cyan
        )
    }

}


@Composable
fun MyProgressBar2() {
    var show by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (show) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 15.dp)
            LinearProgressIndicator(
                Modifier.padding(top = 40.dp),
                color = Color.Blue,
                trackColor = Color.Cyan
            )
        }
        Button(onClick = { show = !show }, Modifier.padding(top = 20.dp)) {
            Text(text = "Pulsar")
        }
    }

}


@Composable
fun MyProgressBar3() {
    var valor by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = valor)
        LinearProgressIndicator(progress = valor, Modifier.padding(top = 20.dp, bottom = 20.dp))
        Row {
            Button(onClick = { if (valor < 1f) valor += .1f }) {
                Text("+")
            }
            Button(onClick = {
                if (valor > 0) valor -= .100f
                println(valor)
            }) {
                Text("-")
            }

        }
    }

}

@Composable
fun MySwitch() {
    var estado by rememberSaveable {
        mutableStateOf(true)
    }
    Switch(
        checked = estado,
        onCheckedChange = { estado = !estado },
        enabled = true,
        colors = SwitchDefaults.colors(

            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedBorderColor = Color.Black,
            checkedBorderColor = Color.Cyan,
            uncheckedTrackColor = Color.Yellow,
            checkedTrackColor = Color.Blue,


            )
    )
}


@Composable
fun MycCheckBox() {
    var estado by rememberSaveable {
        mutableStateOf(true)
    }
    Checkbox(
        checked = estado,
        onCheckedChange = { estado = !estado },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            checkmarkColor = Color.Green
        )
    )

}


@Composable
fun MycCheckBoxConTexto() {
    var estado by rememberSaveable {
        mutableStateOf(true)
    }
    Row(

        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = estado,
            onCheckedChange = { estado = !estado },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                checkmarkColor = Color.Green
            )
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Check")
    }

}


@Composable
fun MyTristatusCheckBox() {

    var estado by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = estado, onClick = {
        estado = when (estado) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //MyButtonExample()
    //MyImageExample()
    //MyCircularImageExample()
    //MyIcon()
    //MyProgressBar3()
    //MySwitch()
    //MycCheckBox()
    MycCheckBoxConTexto()

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SEgundaParteComponebtesTheme {
        Greeting("Android")
    }
}