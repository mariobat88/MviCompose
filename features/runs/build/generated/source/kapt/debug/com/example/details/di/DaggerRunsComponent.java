package com.example.details.di;

import com.example.details.RunsViewModel;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerRunsComponent implements RunsComponent {
  private final RunsModuleDependencies runsModuleDependencies;

  private DaggerRunsComponent(RunsModuleDependencies runsModuleDependenciesParam) {
    this.runsModuleDependencies = runsModuleDependenciesParam;
  }

  public static RunsComponent.Factory factory() {
    return new Factory();
  }

  @Override
  public RunsViewModel viewModel() {
    return new RunsViewModel(Preconditions.checkNotNull(runsModuleDependencies.gamesRepository(), "Cannot return null from a non-@Nullable component method"));
  }

  private static final class Factory implements RunsComponent.Factory {
    @Override
    public RunsComponent create(RunsModuleDependencies runsModuleDependencies) {
      Preconditions.checkNotNull(runsModuleDependencies);
      return new DaggerRunsComponent(runsModuleDependencies);
    }
  }
}
