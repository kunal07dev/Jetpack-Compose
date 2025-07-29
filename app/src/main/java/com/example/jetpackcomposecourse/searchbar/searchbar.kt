package com.example.jetpackcomposecourse.searchbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun searchscree() {
    val textFieldState = remember { TextFieldState() }
    var searchresult by remember { mutableStateOf(listOf<String>()) }
    val onSearch: (String) -> Unit = { query ->
        searchresult = listOf(
            "result 1 for$query",
            "result 2 for$query",
            "result 3 for $query"
        )

    }
    SimpleSearchScreen(
        textFieldState = textFieldState,
        onSearch = onSearch,
        searchResults = searchresult
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchScreen(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { isTraversalGroup },
            inputField = {
                InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = { newText ->
                        textFieldState.edit {
                            replace(0, length, newText)
                        }
                    },
                    onSearch = {
                        onSearch(textFieldState.text.toString())
                        expanded = true
                    },
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = it
                    },
                    placeholder = { Text("Search") }
                )
            }, expanded = expanded,
            onExpandedChange = { expanded = it }
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach{ result ->
                ListItem(
                    headlineContent = { Text(result) },
                    modifier = Modifier.clickable {
                        textFieldState.edit {
                            replace(0, length, result)
                        }
                        expanded = false

                    }
                        .fillMaxWidth()
                )

            }
        }
    }
}
}
@Preview(showSystemUi = true)
@Composable
fun prev(){
    searchscree()
}




