package com.alejo.a30daysofimprovement

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alejo.a30daysofimprovement.model.DailyActivity
import com.example.compose._30DaysOfImprovementTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ActivityCard(dailyActivity: DailyActivity, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Text(
                text = stringResource(dailyActivity.dayRes),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.displayMedium,
            )
            if (expanded) {
                Image(
                    painter = painterResource(dailyActivity.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(dailyActivity.descriptionRes),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.everyday_title),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = stringResource(R.string.everyday_activity),
                    modifier = modifier.padding(8.dp)
                )
            }

            CardButton(
                expanded = expanded,
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .fillMaxWidth(),

                )

        }
    }
}

@Composable
private fun CardButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Preview("Light Theme")
@Composable
fun CardPreview() {
    val activity = DailyActivity(
        R.string.day1,
        R.string.description1,
        R.drawable.image1
    )


    _30DaysOfImprovementTheme {
        ActivityCard(activity)
    }
}