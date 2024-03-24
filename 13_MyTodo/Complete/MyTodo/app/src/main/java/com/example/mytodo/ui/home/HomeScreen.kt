package com.example.mytodo.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytodo.R
import com.example.mytodo.data.Item
import com.example.mytodo.data.ItemsRepository
import com.example.mytodo.ui.AppViewModelProvider
import com.example.mytodo.ui.TodoTopAppBar
import com.example.mytodo.ui.navigation.NavigationDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object HomeDestination : NavigationDestination {
  override val route = "home"
  override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  navigateToItemEntry: () -> Unit = {},
  navigateToItemUpdate: (Int) -> Unit = {},
  modifier: Modifier = Modifier,
  viewModel: HomeViewModel =
    viewModel(factory = AppViewModelProvider.Factory)
) {
  val itemList by viewModel.homeUiState.itemList
    .collectAsState(initial = emptyList())
  var showDone by remember { mutableStateOf(false) }
  var filteredItemList by remember(itemList, showDone) {
    mutableStateOf(itemList.filter {
      if (showDone) true
      else it.done == false
    })
  }
  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
  Scaffold(
    modifier = modifier
      .nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TodoTopAppBar(
        title = stringResource(R.string.app_name),
        canNavigateBack = false,
        scrollBehavior = scrollBehavior
      )
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = navigateToItemEntry,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
          .padding(dimensionResource(id = R.dimen.padding_large))
      ) {
        Icon(
          imageVector = Icons.Default.Add,
          contentDescription = stringResource(R.string.item_entry_title)
        )
      }
    }) { innerPadding ->
    HomeBody(
      itemList = filteredItemList,
    onItemClick = { navigateToItemUpdate(it.id) },
    onCheckedChange = {
      showDone = it
    },
    modifier = Modifier
      .padding(innerPadding)
      .fillMaxSize()
    )
  }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
  val mockObject = object : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = MutableStateFlow(
      listOf(
        Item(1, "Item 1", "Description 1", true),
        Item(2, "Item 2", "Description 2", false),
        Item(3, "Item 3", "Description 3", false)
      )
    )

    override fun getItemStream(id: Int): Flow<Item?> = MutableStateFlow(
      Item(1, "Item 1", "Description 1", false)
    )

    override suspend fun insertItem(item: Item) {}
    override suspend fun deleteItem(item: Item) {}
    override suspend fun updateItem(item: Item) {}
  }

  HomeScreen(
    navigateToItemEntry = {},
    navigateToItemUpdate = {},
    viewModel = HomeViewModel(mockObject)
  )
}

