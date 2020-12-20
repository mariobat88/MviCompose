package com.example.details;

import com.example.games.GamesRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RunsViewModel_Factory implements Factory<RunsViewModel> {
  private final Provider<GamesRepository> gamesRepositoryProvider;

  public RunsViewModel_Factory(Provider<GamesRepository> gamesRepositoryProvider) {
    this.gamesRepositoryProvider = gamesRepositoryProvider;
  }

  @Override
  public RunsViewModel get() {
    return newInstance(gamesRepositoryProvider.get());
  }

  public static RunsViewModel_Factory create(Provider<GamesRepository> gamesRepositoryProvider) {
    return new RunsViewModel_Factory(gamesRepositoryProvider);
  }

  public static RunsViewModel newInstance(GamesRepository gamesRepository) {
    return new RunsViewModel(gamesRepository);
  }
}
