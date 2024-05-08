package com.example.meals_app_clean_archi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CategoryResponse
import com.example.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals
): ViewModel() {

    private val _categories:MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)

    val category : StateFlow<CategoryResponse?> = _categories
    fun getMeals(){
        viewModelScope.launch {
            try {
                getMealsUseCase()
            }catch(e:Exception){
                println("MealsCategoryResponse "+e.message.toString())
            }
        }
    }
}