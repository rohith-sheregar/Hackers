import plotly.express as px
df = px.data.gapminder()
df_asia = df[df['continent'] == 'Asia']
fig = px.line_3d(df_asia, x="gdpPercap", y="pop", z="year", color="country", title="Economic evolution of Asian countries over time")
fig.show()
